<li class="list-group-item">
    <f:field bean="${controllerName}" property="${property!=""?property+".":""}nombre"/>
    <f:field bean="${controllerName}" property="${property!=""?property+".":""}apellidoPaterno"/>
    <f:field bean="${controllerName}" property="${property!=""?property+".":""}apellidoMaterno"/>
    <f:field bean="${controllerName}" property="${property!=""?property+".":""}fechaNacimiento"/>
    <f:field bean="${controllerName}" property="${property!=""?property+".":""}curp"/>
    <f:field bean="${controllerName}" property="${property!=""?property+".":""}sexo"/>

</li>
<f:field bean="usuario" property="persona.direccion"/>
