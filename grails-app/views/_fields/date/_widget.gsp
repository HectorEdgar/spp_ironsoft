<g:textField
        name="${property}"
        placeholder="yyyy-mm-dd"
        id="datepicker"
        value="${value?.format('yyyy-MM-dd')}"
        required="${required}"
        class="form-control ${errors?"is-invalid":""}"
/>

