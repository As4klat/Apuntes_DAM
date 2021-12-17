const fs = require('fs')
const chalk = require('chalk')

const addCliente = (id, nombre) => {
    const clientes = cargarClientes()
    const clienteDuplicado = clientes.find((cliente) => cliente.id === id)

    if (!clienteDuplicado) {
        clientes.push({
            id: id,
            nombre: nombre
        })
        saveClientes(clientes)
        console.log(chalk.green.inverse('Se ha añadido un nuevo cliente!'))
    } else {
        console.log(chalk.red.inverse('No se ha podido crear el cliente con id: ' + id + ' Ya existe.'))
    }
}

const addFactura = (idCliente, idFactura, total) => {
    const facturas = cargarFacturas()
    const clientes = cargarClientes()

    const facturaDuplicada = facturas.find((factura) => factura.idFactura === idFactura)
    const clienteExiste = clientes.find((cliente) => cliente.id === idCliente)

    if(clienteExiste){
        if (!facturaDuplicada) {
            facturas.push({
                idCliente: idCliente,
                idFactura: idFactura,
                total: total
            })
            saveFacturas(facturas)
            console.log(chalk.green.inverse('Se ha añadido una nueva factura!'))
        } else {
            console.log(chalk.red.inverse('No se ha podido crear la factura con id: ' + idFactura + ' Ya existe.'))
        }
    }
    else{
        console.log(chalk.red.inverse('No se existe el cliente con id:' + idCliente))
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
    //removeCliente: removeCliente
}