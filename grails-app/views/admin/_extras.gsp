<sec:ifLoggedIn>
    <sec:ifAllGranted roles="ROLE_ADMIN">
        <br/>
        <div id="extras">
            <h3>Request Parameters</h3>
            <div>
                <g:render template="/common/keyValue" model="[map: params]"/>
            </div>
            <h3>Request Attributes</h3>
            <div>
                <g:render template="/common/keyValue" model="[map: request.attributeNames.toList().collectEntries { [(it): request.getAttribute(it)] } ]"/>
            </div>
            <h3>Session Atttributes</h3>
            <div>
                <g:render template="/common/keyValue" model="[map: session.attributeNames.toList().collectEntries { [(it): session.getAttribute(it)] } ]"/>
            </div>
        </div>
<g:javascript>
$(function() {
    $('#extras').accordion({
      collapsible: true,
      heightStyle: "content"
    });
});
</g:javascript>
    </sec:ifAllGranted>
</sec:ifLoggedIn>
