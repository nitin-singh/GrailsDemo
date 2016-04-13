<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Data</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.11/js/dataTables.jqueryui.min.js"></script>
    <asset:stylesheet href="jquery-ui.css" />
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

    <script type="text/javascript">
        $(document).ready(function() {
            jQuery('#example').dataTable();
        } );
    </script>
</head>

<body>
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

        <tbody>
        <g:each in="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.email}</td>
                <td><g:link controller="user" action="edit" params="[userId: user.id]">Edit</g:link></td>
                <td><g:link controller="user" action="delete" params="[userId: user.id]">Delete</g:link></td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>