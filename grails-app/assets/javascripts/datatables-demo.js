// Call the dataTables jQuery plugin
$(function () {
    $('table').dataTable({
        "lengthMenu": [[10, 30, -1], [10, 30, "Todos"]],
        "lengthChange": true,
        "paging": true,
        "searching": true,
        "length": true,
        "autoWidth": true,
        "order": [[0, "asc"]],
        "language": {
            "emptyTable": "Sin registros",
            "info": "Registros _START_ a _END_. Total: _TOTAL_",
            "infoEmpty": "Sin registros por mostrar",
            "infoFiltered": "(_MAX_ registros filtrados)",
            "lengthMenu": "Mostrar _MENU_ registros",
            "loadingRecords": "Cargando...",
            "processing": "Procesando...",
            "search": "Buscar:",
            "zeroRecords": "No se encontraron resultados",
            "paginate": {
                "first": "Inicio",
                "last": "Fin",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        }
    });

});
