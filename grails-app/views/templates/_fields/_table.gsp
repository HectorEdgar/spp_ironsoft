<table class="table table-hover table-responsive table-responsive-xl table-responsive-md table-responsive-sm table-responsive-lg" id="dataTable" width="100%" cellspacing="0"">
    <thead class="thead-dark text-white">
    <tr>
        <g:each in="${domainProperties}" var="p" status="i">
            <th scope="col">
                ${p.label}
            </th>
        </g:each>
    </tr>
    </thead>
    <tfoot class="">
    <tr>
        <g:each in="${domainProperties}" var="p" status="i">
            <th scope="col">
                ${p.label}
            </th>
        </g:each>
    </tr>
    </tfoot>
    <tbody>
    <g:each in="${collection}" var="bean" status="i">
        <tr class="">
            <g:each in="${domainProperties}" var="p" status="j">
                <g:if test="${j==0}">
                    <td><g:link method="GET" class="text-truncate" resource="${bean}"><f:display bean="${bean}" property="${p.property}" displayStyle="${displayStyle?:'table'}" theme="${theme}"/></g:link></td>
                </g:if>
                <g:else>
                    <td><f:display class="text-truncate" bean="${bean}" property="${p.property}" displayStyle="${displayStyle?:'table'}" theme="${theme}"/></td>
                </g:else>
            </g:each>
        </tr>
    </g:each>
    </tbody>
</table>