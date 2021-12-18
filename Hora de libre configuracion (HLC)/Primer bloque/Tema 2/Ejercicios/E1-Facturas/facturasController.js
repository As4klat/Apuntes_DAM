const fs = require('fs')
const chalk = require('chalk')

const addCliente = (nombre) => {
    const clientes = cargarClientes()
    const clienteDuplicado = clientes.find((cliente) => cliente.nombre === nombre)

    if (!clienteDuplicado) {
        var idIndex = clientes.length
        clientes.push({
            id: idIndex,
            nombre: nombre
        })
        saveClientes(clientes)
        console.log(chalk.green.inverse('Se ha añadido un nuevo cliente!'))
    } else {
        console.log(chalk.red.inverse('No se ha podido crear el cliente ' + nombre + ' Ya existe.'))
    }
}

const addFactura = (idCliente, total) => {
    const facturas = cargarFacturas()
    const clientes = cargarClientes()

    const clienteExiste = clientes.find((cliente) => cliente.id == idCliente)

    if(clienteExiste){
        var idFactura = facturas.length
            facturas.push({
                idFactura: idFactura,
                idCliente: idCliente,
                total: total
            })
            saveFacturas(facturas)
            console.log(chalk.green.inverse('Se ha añadido una nueva factura!'))
    }
    else{
        console.log(chalk.red.inverse('No existe el cliente con id:' + idCliente))
    }
    
}

const listaClientes = () => {
    const clientes = cargarClientes()

    console.log(chalk.inverse('------ Clientes ------'))

    clientes.forEach((cliente) => {
        console.log(cliente.id + ": " + cliente.nombre)
    })
}

const listaFacturas = () => {
    const facturas = cargarFacturas()

    console.log(chalk.inverse('------ Facturas ------'))

    facturas.forEach((factura) => {
        console.log(factura.idFactura + ": " + " --- Cliente: " + factura.idCliente + " Total: " + factura.total)
    })
}

const removeCliente = (idCliente) => {
    var clientes = cargarClientes()
    var facturas = cargarFacturas()
    const clienteExiste = clientes.find((cliente) => cliente.id == idCliente)

    if(clienteExiste){
        clientes = clientes.filter((cliente) => cliente.id != idCliente)
        facturas = facturas.filter((factura) => factura.idCliente != idCliente)
        clientes.forEach((cliente) => {
            if(cliente.id > idCliente){
                cliente.id--
            }
        })
        for(var i = 0; i < facturas.length; i++){
            if(facturas[i].idFactura != i){
                facturas[i].idFactura = i
            }
        }
        console.log(chalk.green.inverse('Se ha borrado con exito.'))
        saveClientes(clientes)
        saveFacturas(facturas)
    } else {
        console.log(chalk.red.inverse('No existe el cliente con id: ' + idCliente))
    }
}

const removeFactura = (idFactura) => {
    var facturas = cargarFacturas()
    const facturaExiste = facturas.find((factura) => factura.idFactura == idFactura)

    if(facturaExiste){
        facturas = facturas.filter((factura) => factura.idFactura != idFactura)
        facturas.forEach((factura) => {
            if(factura.idFactura > idFactura){
                factura.idFactura--
            }
        })
        console.log(chalk.green.inverse('Se ha borrado con exito.'))
        saveFacturas(facturas)
    } else {
        console.log(chalk.red.inverse('No existe el cliente con id: ' + idFactura))
    }
}

const listaFacturasCliente = (idCliente) => {
    const facturas = cargarFacturas()
    const clientes = cargarClientes()

    const cliente = clientes.find(function(cliente) {
        return cliente.id == idCliente;
    })

    console.log(chalk.inverse('------ Facturas del cliente ' + cliente.nombre + ' ------'))

    facturas.forEach((factura) => {
        if(factura.idCliente == idCliente){
            console.log(factura.idFactura + ": ---Total: " + factura.total)
        }
    })
}

const saveClientes = (clientes) => {
    const dataJSON = JSON.stringify(clientes)
    fs.writeFileSync('clientes.json', dataJSON)
}

const cargarClientes = () => {
    try {
        const dataBuffer = fs.readFileSync('clientes.json')
        const dataJSON = dataBuffer.toString()
        return JSON.parse(dataJSON)
    } catch (e) {
        return []
    }
}

const saveFacturas = (facturas) => {
    const dataJSON = JSON.stringify(facturas)
    fs.writeFileSync('facturas.json', dataJSON)
}

const cargarFacturas = () => {
    try {
        const dataBuffer = fs.readFileSync('facturas.json')
        const dataJSON = dataBuffer.toString()
        return JSON.parse(dataJSON)
    } catch (e) {
        return []
    }
}

module.exports = {
    addCliente: addCliente,
    addFactura: addFactura,
    listaClientes: listaClientes,
    listaFacturas: listaFacturas,
    removeCliente: removeCliente,
    removeFactura: removeFactura,
    listaFacturasCliente: listaFacturasCliente
}