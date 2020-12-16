
$(document).ready(function () {

    var startFrom = 0;
    var rows = 5;
    var sizeOfTable = $("#totalRows").val();
    var pages = Math.ceil((sizeOfTable / rows));

    createButton(pages);

    $("#entries").change(function () {
        rows = $("#entries").val();
        pages = Math.ceil((sizeOfTable / rows));

        console.log('rows:' + rows + "\tpages:" + pages);

        $("input").remove();
        createButton(pages);

        $.ajax({
            url: 'pagination.action',
            data: 'noOfRows=' + rows + "&firstValue=" + startFrom,
            success: function (result) {
                $("#employeeTable").html(result);
            }
        });
    });


    function createButton(pages) {
        var docFrag = document.createDocumentFragment();
        for (let pageNumber = 0; pageNumber < pages; pageNumber++) {
            var elem = document.createElement('input');
            elem.type = 'button';
            elem.id = 'page-btn';
            elem.value = pageNumber + 1;
            elem.class = 'btn';
            docFrag.appendChild(elem);
            elem.onclick = function () {
                selectedPage(pageNumber);
            };
        }

        $("#pagination-buttons").append(docFrag);
    }

    function selectedPage(page) {
        var n = page * rows;
        $.ajax({
            url: 'pagination.action',
            data: 'noOfRows=' + rows + "&firstValue=" + n,
            success: function (result) {
                $("#employeeTable").html(result);
            }
        });
    }


    var currentPage = 1;

    $("#next-btn").click(function () {
        $('#previous-btn').prop('disabled', false);
        rows = $("#entries").val();

        if (currentPage < pages) {
            ++currentPage;
            startFrom += parseInt(rows);
            console.log('currentPage:' + currentPage + "\tPages:" + pages + "\tStart From:" + startFrom);

            $.ajax({
                url: 'pagination.action',
                data: 'noOfRows=' + rows + "&firstValue=" + startFrom,
                success: function (result) {
                    $("#employeeTable").html(result);
                }
            });
        } else {
            $('#next-btn').prop('disabled', true);
        }
    });

    $("#previous-btn").click(function () {
        $('#next-btn').prop('disabled', false);
        rows = $("#entries").val();

        if (currentPage > 1) {
            startFrom = startFrom - parseInt(rows);
            --currentPage;
            console.log(currentPage);
            $.ajax({
                url: 'pagination.action',
                data: 'noOfRows=' + rows + "&firstValue=" + startFrom,
                success: function (result) {
                    $("#employeeTable").html(result);
                }
            });
        } else {
            $('#previous-btn').prop('disabled', true);
        }
    });


    $("#first-btn").click(function () {

        $('#next-btn').prop('disabled', false);
        $('#previous-btn').prop('disabled', true);
        startFrom = 0;
        $.ajax({
            url: 'pagination.action',
            data: 'noOfRows=' + rows + "&firstValue=" + startFrom,
            success: function (result) {
                $("#employeeTable").html(result);
            }
        });
    });

    $("#last-btn").click(function () {
        rows = $("#entries").val();
        pages = Math.floor(sizeOfTable / rows);
        startFrom = pages * rows;
        $('#next-btn').prop('disabled', true);
        $('#previous-btn').prop('disabled', false);
        $.ajax({
            url: 'pagination.action',
            data: 'noOfRows=' + rows + "&firstValue=" + startFrom,
            success: function (result) {
                $("#employeeTable").html(result);
            }
        });
    });
});