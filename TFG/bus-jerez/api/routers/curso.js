const express = require('express')
const Curso = require('../models/parada')
const router = new express.Router()
const auth = require('../middleware/auth')

router.post('/cursos', auth,  async (req, res) => {
    
    const curso = new Curso(
        {
            ...req.body,
            owner: req.user._id
        }
    )

    try {
        await curso.save()
        res.status(201).send(curso)
    } catch (e) {
        res.status(400).send(e)
    }
})

router.get('/cursos', async (req, res) => {
    try {
        const curso = await Curso.find({})
        res.send(curso)
    } catch (e) {
        res.status(500).send()
    }
})

router.get('/mis-cursos', auth ,async (req, res) => {
    try {
        const curso = await Curso.find({owner:req.user})
        res.send(curso)
    } catch (e) {
        res.status(500).send()
    }
})

router.get('/cursos/:id', async (req, res) => {
    const _id = req.params.id

    try {
        const curso = await Curso.findById(_id)

        if (!curso) {
            return res.status(404).send()
        }

        res.send(curso)
    } catch (e) {
        res.status(500).send()
    }
})

router.patch('/cursos/:id', auth, async (req, res) => {
    const updates = Object.keys(req.body)
    const allowedUpdates = ['nombre', 'descripcion']
    const isValidOperation = updates.every((update) => allowedUpdates.includes(update))

    if (!isValidOperation) {
        return res.status(400).send({ error: 'No se pudo actualizar!' })
    }

    try {
        const curso = await Curso.findById(req.params.id)

        updates.forEach((update) => curso[update] = req.body[update])
        await curso.save()

        if (!curso) {
            return res.status(404).send()
        }

        res.send(curso)
    } catch (e) {
        res.status(400).send(e)
    }
})

router.delete('/cursos/:id', auth, async (req, res) => {
    try {
        const curso = await Curso.findByIdAndDelete(req.params.id)

        if (!curso) {
            res.status(404).send()
        }
        
        res.send(curso)
    } catch (e) {
        res.status(500).send()
    }
})

module.exports = router