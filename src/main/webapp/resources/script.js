$(function () {
    console.log("ready ajax!->1");

    $.ajax({
        url: "http://localhost:8080/person/all",
        // data: data,
        success: function (response) {
            console.log(response);
            // var myRecords = JSON.parse(data);
            var dynatable  = $('#my-final-table').dynatable({
                dataset: {
                    records: response,
                    perPageOptions: [2, 4, 3, 5],
                }
            }).data('dynatable');
            dynatable.settings.dataset.originalRecords = response;
            dynatable.process();
        }
    });

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
});