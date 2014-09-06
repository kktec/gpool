<g:form action="delete">
    <g:hiddenField name="id" value="${id}"/>
    <input type="image" alt="x" name="delete" src="${assetPath(src: 'skin/database_delete.png')}"
        onclick="return confirm('Are you sure want to delete ${type} ${name} ?')"/>
</g:form>