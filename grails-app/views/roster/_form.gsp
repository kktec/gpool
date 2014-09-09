<fieldset class="form">
    <g:hiddenField name="id" value="${roster.id}"/>
    <div class="fieldcontain required">
        <label for="name">Name:</label>
        <g:textField name="name" required="required" value="${roster.name}"/>
    </div>
    <div class="fieldcontain required">
        <label for="name">Type:</label>
        <g:select id="type" name='type' value="${roster.type?.id}"
            noSelection="${['null':'Select One...']}"
            from='${types}'
            optionKey="id" optionValue="name"></g:select>
    </div>
</fieldset>
<fieldset class="buttons">
    <g:submitButton name="saveRoster" value="Save Roster"/>
</fieldset>
