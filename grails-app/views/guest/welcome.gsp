<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
    <asset:stylesheet href="dataTables/css/jquery.dataTables.css"/>
    <asset:stylesheet href="dataTables/css/jquery.dataTables_themeroller.css"/>
    <asset:javascript src="jquery.dataTables.js"/>
</head>
<body>
    <section>
        <p>&nbsp;</p>
        <p>You must <g:link action="register">Register</g:link> to use this site.</p>
        <p>&nbsp;</p>
        <p>Once you have registered, you may <g:link action="signIn">Sign In</g:link>.</p>
    </section>
    <section>&nbsp;</section>
    
<%--    <div><input name="dp" id="dp"></div>--%>
    
<%--<g:javascript>--%>
<%--  $(document).ready(function() {--%>
<%--      var dpconf = {--%>
<%--          dateFormat: 'yy-mm-dd',--%>
<%--          autoSize: true,--%>
<%--          showOtherMonths: true,--%>
<%--          selectOtherMonths: true--%>
<%--      };--%>
<%--      $('#dp').datepicker(dpconf);--%>
<%--  });--%>
<%--</g:javascript>--%>

<%--<table id="dt">--%>
<%--    <thead>--%>
<%--        <tr>--%>
<%--            <th>Odd</th>--%>
<%--            <th>Even</th>--%>
<%--            <th>a</th>--%>
<%--            <th>b</th>--%>
<%--            <th>c</th>--%>
<%--            <th>d</th>--%>
<%--            <th>e</th>--%>
<%--            <th>f</th>--%>
<%--        </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <g:each var='i' in="${1..150}">--%>
<%--        <tr>--%>
<%--            <td>${i}</td>--%>
<%--            <td>${i + 1}</td>--%>
<%--            <td>${'a___' +  (i + 2)}</td>--%>
<%--            <td>${'b___' + (i + 3)}</td>--%>
<%--            <td>${'c______' +  (i + 4)}</td>--%>
<%--            <td>${'d______' + (i + 5)}</td>--%>
<%--            <td>${'e________' +  (i + 6)}</td>--%>
<%--            <td>${'f________' + (i + 7)}</td>--%>
<%--        </tr>--%>
<%--    </g:each>--%>
<%--    </tbody>--%>
<%--</table>--%>
<%----%>
<%--<g:javascript>--%>
<%--    $(document).ready(function() {--%>
<%--        $('#dt').dataTable({--%>
<%--            'jQueryUI': true--%>
<%--        });--%>
<%--    });--%>
<%--</g:javascript>--%>
</body>
</html>
