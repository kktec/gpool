<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
    <g:render template="/common/dataTables"/>
</head>
<body>
    <div>
        <br/>
        <table id="types">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
            <g:each var='t' in="${types}">
                <tr>
                    <td><g:link action="edit" id="${t.id}">${t.id}</g:link></td>
                    <td>${t.name}</td>
                    <td><g:render template="/common/delete" model="[id: t.id, name: t.name, type: 'Type']"/></td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
    <br/>
    <div class="nav">
        <ul>
            <li><g:link action="addNew">Add New Type</g:link></li>
        </ul>
     </div>
<g:javascript>
    $(document).ready(function() {
        $('#types').dataTable({
            'jQueryUI': true
        });
    });
</g:javascript>
</body>
</html>
