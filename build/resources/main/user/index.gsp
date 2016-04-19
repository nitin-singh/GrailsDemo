<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Select option</title>

<asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<sec:ifLoggedIn>
    <div>
        <g:link controller="user" action="register">Register</g:link>
    </div>

    <sec:ifAllGranted roles="ROLE_ADMIN">
        <div>
            <g:link controller="user" action="viewPage">View</g:link>
        </div>
    </sec:ifAllGranted>


    <div>
        <g:link controller="logout">Logout</g:link>
    </div>
</sec:ifLoggedIn>
</body>
</html>
