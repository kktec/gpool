<fieldset class="form">
    <g:hiddenField name="id" value="${type.id}"/>
    <div class="fieldcontain required">
        <label for="name">Name:</label>
        <g:textField name="name" required="required" value="${type.name}"/>
    </div>
</fieldset>
<fieldset class="buttons">
    <g:submitButton name="saveType" value="Save Type"/>
</fieldset>
