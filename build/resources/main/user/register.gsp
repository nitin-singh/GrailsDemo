<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Registration</title>
</head>

<body>

<div class="panel-body">
<!--Form Opening-->
    <g:form class="form-vertical" controller="user" action="registeration">
        <div class="form-group">
            <label class="control-label col-sm-4">First Name *</label>

            <div class="col-sm-8">
                <g:textField name="firstName" id="firstname" type="text" class="form-control"></g:textField>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4">Last Name *</label>

            <div class="col-sm-8">
                <g:textField name="lastName" id="lastname" type="text" class="form-control"></g:textField>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4">Email *</label>

            <div class="col-sm-8">
                <g:textField name="email" id="email" type="email" class="form-control"></g:textField>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="userName">Username *</label>

            <div class="col-sm-8">
                <g:textField name="userName" id="username" class="form-control"></g:textField>
            </div>

            <div class="alert-danger"><g:fieldError field="userName" bean="${user}"/></div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4">Password *</label>

            <div class="col-sm-8">
                <g:passwordField name="password" id="password" class="form-control"></g:passwordField>
            </div>
        </div>

        <div>
            <g:actionSubmit value="Register" action="registeration" name="Register" class="btn btn-default"
                            style="float:right; background-color:#d2d4d9"></g:actionSubmit>
        </div>
    </g:form>
<!--Form Closing-->
</div>
</body>
</html>