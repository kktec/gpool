<!DOCTYPE html>
<html>
	<head>
		<title>Error</title>
		<meta name="layout" content="gpool">
		<asset:stylesheet src="errors.css"/>
	</head>
	<body>
        <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_POOL">
            <g:renderException exception="${exception}" />
        </sec:ifAnyGranted>
        <sec:ifNotGranted roles="ROLE_ADMIN,ROLE_POOL">
            <ul class="errors">
                <li>An error has occurred: ${exception.message}</li>
            </ul>
        </sec:ifNotGranted>
	</body>
</html>
