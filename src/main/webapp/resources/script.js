$(function () {
    console.log("ready ajax!->1");

    // $.ajax({
    //     url: "http://localhost:8080/person/all",
    //     // data: data,
    //     success: function (response) {
    //         console.log(response);
    //     }
    // });

    // $('#my-final-table').dynatable({
    //     dataset: {
    //         ajax: true,
    //         ajaxMethod: 'POST',
    //         ajaxUrl: "/person/all",
    //         ajaxOnLoad: true,
    //         records: [],
    //
    //     }
    // });
    $("#sample-grid").tabulator({
        layout:"fitColumns",
        tooltips:true,
        addRowPos:"top",
        history:true,
        pagination:"local",
        paginationSize:7,
        movableColumns:true,
        initialSort:[
            {column:"id", dir:"asc"},
        ],
        columns: [
            {title: "ID", field: "id", sortable: true,
                width: 40,
                sorter: "number"},
            {title: "First name", field: "firstName", sortable: true,
                // width: 400,
                filterType: "search"},
            {title: "Last name", field: "lastName", sortable: true,
                // width: 400,
                filterType: "search"},
        ],
    });
    // $.ajax({
    //     url: "http://localhost:8080/person/all",
    //     // data: data,
    //     success: function (response) {
    //         $("#sample-grid").tabulator("setData", response);
    //         console.log(response);
    //     }
    // });

    $("#sample-grid").tabulator("setData", "http://localhost:8080/person/all");
    //
    // // Initialize table
    // $("#sample-grid").dynamicTable({
    //     fillParent: false,
    //     showCounter: true
    // });
    //
    // // Define columns
    // var myColumns = [
    //     //     {  // Hidden Identifier column
    //     //     name       : "Identifier",
    //     //     type       : "number",
    //     //     visible    : false
    //     // },
    //     {// Limited values with default picklist filter
    //         name: "ID",
    //         type: "number",
    //         visible: true,
    //     }, {// Searchable text column
    //         name: "First name",
    //         type: "string",
    //         visible: true,
    //         filterType: "search",
    //         width: 200
    //     }, {// 2
    //         name: "Last name",
    //         type: "string",
    //         visible: true,
    //         filterType: "search",
    //         width: 200
    //     }];
    //
    //
    // // Get the data. This would usually be done in an AJAS call
    // // ($.getJSON) but for demo purposes we show hardcoded data
    // var myData = [
    //     [10001, "Bill Smith", new Date(1956, 3, 12).getTime(), "United States", "Texas", "", "English"],
    //     [10002, "Michael Jones", new Date(1975, 7, 23).getTime(), "United States", "Florida", "", "English"],
    //     [10003, "Heinz Mayer", new Date(1972, 8, 2), "Germany", "Bayern", "", "German"],
    //     [10004, "Mary Miller", new Date(1981, 1, 6), "United States", "California", "", "English"],
    //     [10005, "Jose Gonzalez", new Date(1959, 1, 6), "Mexico", null, "", "Spanish"],
    //     [10005, "Giovanni D'Agostini", new Date(1875, 2, 3), "Italy", "L'Aquila", "", "Italian"],
    //
    //     [10001, "Bill Smith", new Date(1956, 3, 12), "United States", "Texas", "", "English"],
    //     [10002, "Michael Jones", null, "United States", "Florida", "", "English"],
    //     [10003, "Heinz Mayer", new Date(2015, 8, 2), "Germany", "Bayern", "", "German"],
    //     [10004, "Mary Miller", new Date(1981, 1, 6), "United States", "California", "", "English"],
    //     [10005, "Jose Gonzalez", new Date(1959, 1, 6), "Mexico", null, "", "Spanish"],
    //
    //     [10001, "Bill Smith", new Date(1956, 3, 12), "United States", "Texas", "", "English"],
    //     [10002, "Michael Jones", new Date(1975, 7, 23), "United States", "Florida", "", "English"],
    //     [10003, "Heinz Mayer", null, "Germany", "Bayern", "", "German"],
    //     [10004, "Mary Miller", new Date(1981, 1, 6), "United States", "California", "", "English"],
    //     [10005, "Jose Gonzalez", new Date(1959, 1, 6), "Mexico", null, "", "Spanish"],
    //
    //     [10001, "Bill Smith", new Date(1956, 3, 12), "United States", "Texas", "", "English"],
    //     [10002, "Michael Jones", new Date(1975, 7, 23), "United States", "Florida", "", "English"],
    //     [10003, "Heinz Mayer", new Date(1972, 8, 2), "Germany", "Bayern", "", "German"],
    //     [10004, "Mary Miller", new Date(1981, 1, 6), "United States", "California", "", "English"],
    //     [10005, "Jose Gonzalez", new Date(1959, 1, 6), "Mexico", null, "", "Spanish"],
    //
    //     [10001, "Bill Smith", new Date(1956, 3, 12), "United States", "Texas", "", "English"],
    //     [10002, "Michael Jones", new Date(1975, 7, 23), "United States", "Florida", "", "English"],
    //     [10003, "Heinz Mayer", new Date(1972, 8, 2), "Germany", "Bayern", "", "German"],
    //     [10004, "Mary Miller", new Date(1981, 1, 6), "United States", "California", "", "English"],
    //     [10005, "Jose Gonzalez", new Date(1959, 1, 6), "Mexico", null, "", "Spanish"],
    //
    //     [10001, "Bill Smith", new Date(1956, 3, 12), "United States", "Texas", "", "English"],
    //     [10002, "Michael Jones", new Date(1975, 7, 23), "United States", "Florida", "", "English"],
    //     [10003, "Heinz Mayer", new Date(1972, 8, 2), "Germany", "Bayern", "", "German"],
    //     [10004, "Mary Miller", new Date(1981, 1, 6), "United States", "California", "", "English"],
    //     [10005, "Jose Gonzalez", new Date(1959, 1, 6), "Mexico", null, "", "Spanish"],
    //
    // ];
    //
    // // Load the data into the grid
    // $("#sample-grid").dynamicTable("data", myData, myColumns);
    //
    // // Add event listeners:
    // $("#sample-grid").on("rowSelect", function (aEvent) {
    //     $("#selected-data").html("You selected <strong>" + aEvent.row[1] + "</strong>");
    // });
    //
    // // Add event listeners:
    // $("#sample-grid").on("rowDoubleClick", function (aEvent) {
    //     $("#selected-data").html("You <em>double-clicked</em> <strong>" + aEvent.row[1] + "</strong>");
    // });
    //
    // $("#clear-all-button").click(function () {
    //     $("#sample-grid").dynamicTable("clearAllFilters");
    // })
});