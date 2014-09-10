<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
    <g:render template="/common/dataTables"/>
</head>
<body>
    <div>
        <br/>
        <table id="rosters">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Contestants</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
            <g:each var='r' in="${rosters}">
                <tr>
                    <td><g:link action="edit" id="${r.id}">${r.id}</g:link></td>
                    <td>${r.name}</td>
                    <td>${r.type}</td>
                    <td><g:link action="contestants" id="${r.id}">${r.contestants.size()}</g:link></td>
                    <td><g:render template="/common/delete" model="[id: r.id, name: r.name, type: 'Roster']"/></td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
    <br/>
    <div class="nav">
        <ul>
            <li><g:link action="addNew">Add New Roster</g:link></li>
        </ul>
     </div>
    <br/>
<g:javascript>
    $(document).ready(function() {
        $('#rosters').dataTable({
            'jQueryUI': true
        });
    });
</g:javascript>
</body>
</html>
