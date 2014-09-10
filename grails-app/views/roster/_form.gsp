<fieldset class="form">
    <g:hiddenField name="id" value="${roster.id}"/>
    <div class="fieldcontain required">
        <label for="name">Name:</label>
        <g:textField name="name" required="required" value="${roster.name}"/>
    </div>
        <div class="fieldcontain required">
            <label for="name">Type:</label>
            <g:if test="${!roster.id}">
                <g:select name='type' value="${roster.type?.id}"
                    noSelection="${['null': 'Select One...']}" from='${types}'
                    optionKey="id" optionValue="name"></g:select>
            </g:if>
            <g:else>
                <span class="property">${roster.type}</span>
            </g:else>
        </div>
</fieldset>
<fieldset class="buttons">
    <g:submitButton name="saveRoster" value="Save Roster"/>
</fieldset>
