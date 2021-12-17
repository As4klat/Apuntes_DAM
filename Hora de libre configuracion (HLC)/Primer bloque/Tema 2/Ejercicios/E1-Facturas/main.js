const yargs = require('yargs')
const facturasController = require('./facturasController.js')

//  Crear cliente.
yargs.command({
    command: 'addCliente',
    describe: 'Añade un cliente a la lista.',
    builder: {
        id: {
            describe: 'Id del cliente.',
            demandOption: true,
            type: 'string'
        },
        nombre: {
            describe: 'Nombre del cliente.',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        facturasController.addCliente(argv.id, argv.nombre)
    }
})

// Crea factura asociada.
yargs.command({
    command: 'addFactura',
    describe: 'Crea una factura asociada a un cliente.',
    builder: {
        idCliente: {
            describe: 'Id del cliente',
            demandOption: true,
            type: 'string'
        },
        idFactura: {
            describe: 'Id de la factura crada.',
            demandOption: true,
            type: 'string'
        },
        total:{
            describe: 'Total de la factura recibida.',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        facturasController.addFactura(argv.idCliente, argv.idFactura, argv.total)
    }
})

// Lista clientes.
yargs.command({
    command: 'listaClientes',
    describe: 'Lista los clientes actuales.',
    handler(){
        facturasController.listaClientes()
    }
})

//  Lista facturas
yargs.command({
    command: 'listaFacturas',
    describe: 'Lista las facturas actuales.',
    handler(argv){
        facturasController.listaFacturas()
    }
})

// Borra cliente
yargs.command({
    command: 'removeCliente',
    describe: 'Elimina un cliente por su id.',
    builder: {
        idCliente: {
            describe: 'Id del cliente a eliminar.',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
    }
})

// Borra factura
yargs.command({
    command: 'removeFactura',
    describe: 'Elimina una factura por su id.',
    builder: {
        idCliente: {
            describe: 'Id de la factura a eliminar.',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
    }
})

// Lista factura por id cliente
yargs.command({
    command: 'listaFacturasCliente',
    describe: 'Muestra las facturas del cliente selecionado.',
    builder: {
        idCliente: {
            describe: 'Id del cliente a mostrar facturas.',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv){
    }
})

yargs.parse()