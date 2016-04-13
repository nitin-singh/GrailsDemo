<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Edit</title>
</head>
<body>
<div class="panel-body">
<!--Form Opening-->
    <g:form class="form-vertical" controller="user" action="editPage">
        <div class="form-group">
            <label class="control-label col-sm-4">First Name *</label>

            <div class="col-sm-8">
                <g:textField name="firstName" type="text" class="form-control"></g:textField>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4">Last Name *</label>

            <div class="col-sm-8">
                <g:textField name="lastName" type="text" class="form-control"></g:textField>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4">Email *</label>

            <div class="col-sm-8">
                <g:textField name="email" type="email" class="form-control"></g:textField>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="userName">Username *</label>

            <div class="col-sm-8">
                <g:textField name="userName" class="form-control"></g:textField>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4">Password *</label>

            <div class="col-sm-8">
                <g:passwordField name="password" class="form-control"></g:passwordField>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4">Confirm Password *</label>

            <div class="col-sm-8">
                <g:passwordField name="confirmPassword" class="form-control"></g:passwordField>
            </div>
        </div>

        <div>
            <g:actionSubmit value="Edit" action="editPage" name="Edit" class="btn btn-default"
                            style="float:right; background-color:#d2d4d9"></g:actionSubmit>
        </div>
    </g:form>
<!--Form Closing-->
</div>

</body>
</html>