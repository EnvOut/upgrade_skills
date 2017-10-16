package com.tow.spring.jdbc.dao;

import com.tow.spring.jdbc.etc.SelectAllContacts;
import com.tow.spring.jdbc.models.Contact;
import com.tow.spring.jdbc.models.ContactTelDetail;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class PlainContactDao implements ContactDAO {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private DataSource source;

    @Autowired
    private SelectAllContacts selectAllContacts;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init() {
        if (source == null) {
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql:spring",
                "postgres",
                "pass");
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findAllWhithDetail() {
        return jdbcTemplate.query("" +
                        "SELECT c.id, c.first_name, c.last_name, c.birth_date, t.id " +
                        "AS contact_tel_id, t.tel_type, t.tel_number " +
                        "FROM contact c " +
                        "LEFT JOIN contact_tel_detail t " +
                        "ON c.id = t.contact_id",
                (ResultSet rs) -> {
                    Map<Long, Contact> map = new HashMap<>();

                    Contact contact = null;

                    while (rs.next()) {
                        Long id = rs.getLong("id");
                        contact = map.get(id);

                        if (contact == null) {
                            contact = new Contact().setId(id);
                            contact.setId(rs.getLong("id"))
                                    .setFirstName(rs.getString("first_name"))
                                    .setLastName(rs.getString("last_name"))
                                    .setBirthDate(rs.getDate("birth_date"))
                                    .setContactTelDetail(new ArrayList<ContactTelDetail>());
                            map.put(id, contact);
                        }

                        Long contactTelDetailId = rs.getLong("contact_tel_id");
                        if (contactTelDetailId > 0) {
                            ContactTelDetail contactTelDetail = new ContactTelDetail();
                            contactTelDetail.setId(contactTelDetailId);
                            contactTelDetail.setContactId(id);
                            contactTelDetail.setTelType(rs.getString("tel_number"));
                            contact.getContactTelDetail().add(contactTelDetail);
                        }
                    }

                    return new ArrayList<>(map.values());
                });
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        String sql = "SELECT first_name FROM contact WHERE id = :contactId";

        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("contactId", id);

        return jdbcTemplate.queryForObject(
                sql,
                namedParameters,
                String.class);
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Contact contact) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO contact " +
                            "(first_name, last_name, birth_date) " +
                            "VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setDate(3, contact.getBirthDate());

            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                contact.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(Long contactId) {
        Connection connection = null;
        try {
            connection = getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM contact WHERE id=?"
            );

            statement.setLong(1, contactId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private static final class ContactMapper implements RowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setId(rs.getLong("id"))
                    .setFirstName(rs.getString("first_name"))
                    .setLastName(rs.getString("last_name"))
                    .setBirthDate(rs.getDate("birth_date"));
            return contact;
        }
    }
}
