<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Data</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.11/js/dataTables.jqueryui.min.js"></script>
    <asset:stylesheet href="jquery-ui.css"/>
    <asset:stylesheet href="dataTables.jqueryui.min.css"/>
    <style>
    body {
        font: 90%/1.45em "Helvetica Neue", HelveticaNeue, Verdana, Arial, Helvetica, sans-serif;
        margin: 0;
        padding: 0;
        color: #333;
        background-color: #fff;
    }
    </style>

</head>

<body>

<g:if test="${flash.message}">
    <div class="alert alert-success">${flash.message}</div>
</g:if>

<g:if test="${flash.error}">
    <div class="alert alert-danger">${flash.error}</div>
</g:if>

<div class="container">
    <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>S.No</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>User Name</th>
            <th>Email</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>

         <tfoot>
         <tr>
             <th>S.No</th>
             <th>First Name</th>
             <th>Last Name</th>
             <th>User Name</th>
             <th>Email</th>
             <th>Edit</th>
             <th>Delete</th>
         </tr>
         </tfoot>
    </table>
</div>

<script type="text/javascript">

    $(document).ready(function () {

        var table = jQuery("#example").dataTable({
            "bFilter": true,
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "/user/fetchUsers",
                "type": "post",
                data: function (data) {
                    console.log(data.search);
                    return {
                        "start": data.start,
                        "length": data.length,
                        "order": JSON.stringify(data.order),
                        "columns": JSON.stringify(data.columns),
                        "search": JSON.stringify(data.search)
                    }
                }
            },
            "columns": [
                {"data": "id"},
                {"data": "firstName"},
                {"data": "lastName"},
                {"data": "userName"},
                {"data": "email"},
                {"data" : "edit"},
                {"data" : "delete"}
            ]
        });
    });
</script>
</body>
</html>