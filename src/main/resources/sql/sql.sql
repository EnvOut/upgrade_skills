CREATE FUNCTION getFirstNameById(in_id INT)
  RETURNS VARCHAR(60) AS
$code$
SELECT first_name
FROM contact
WHERE id = in_id;
$code$
LANGUAGE SQL