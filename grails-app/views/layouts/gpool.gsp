<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>
            <g:if test="${title}">${title}</g:if>
            <g:else><g:layoutTitle/></g:else>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
        <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
        <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
        <asset:stylesheet src="gpool.css"/>
        <asset:javascript src="gpool.js"/>
        <g:layoutHead/>
    </head>
    <body>
        <header>
            <h1>GPool - sports pools</h1>            
        </header>
        <ul id="tabs">
            <li>
                <ul>
                  <sec:ifLoggedIn>
                      <li><g:link uri="/signOut">Sign Out</g:link></li>
                      <li><g:link uri="/pool/home">Home</g:link></li>
                      <li><g:link uri="/user/profile">Your Profile</g:link></li>
                  </sec:ifLoggedIn>
                  <sec:ifNotLoggedIn>
                      <li><g:link uri="/">Home</g:link></li>
                  </sec:ifNotLoggedIn>
                </ul>
             </li>
        </ul>
        <div id="content">
            <h3 id="heading">${title}</h3>
            <g:if test="${flash.message}">
                <section class="message">${flash.message}</section>
            </g:if>
            <g:layoutBody/>
        </div>
        <footer>GPool <span id="version">v<g:meta name="app.version"/></span> is created by KK Technology Inc. &copy; 2014</footer>
        <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
    </body>
</html>
