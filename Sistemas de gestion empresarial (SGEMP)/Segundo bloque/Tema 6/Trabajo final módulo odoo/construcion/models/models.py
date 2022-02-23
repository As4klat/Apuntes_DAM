# -*- coding: utf-8 -*-

from odoo import models, fields, api

class construcion_parcela(models.Model):
    _name = "construcion.parcela"

    codigo = fields.Char(string="Código", required=True, help="Introduce el código de la parcela")
    tipo = fields.Integer(string="Tipo", required=True)
    size = fields.float(string="Tamaño", required=True)
    encargado = fields.Many2one("construcion.encargado",string="Encargado",required=True)

class construcion_encargado(models.Model):
    _name = "construcion.encargado"

    nombre = fields.Char(string="Nombre", required=True, help="Nombre del encargado")
    telefono = fields.Char(string="Telefono", required=True)
    email = fields.Char(string="Email")
    parcelas = fields.One2many("construcion.parcela","encargado",string="Parcelas")
    numero_parcelas = fields.Integer(string="Número de parcelas a cargo", compute="_nparcelas",store=True)

    @api.depends('parcelas')
    def _nparcelas(self):
        cont=0
        for p in self:
            cont = cont+1
        self.numero_parcelas = cont

class construcion_encargado(models.Model):
    _name = "construcion.cliente"

    nombre = fields.Char(string="Nombre", required=True, help="Nombre del encargado")
    telefono = fields.Char(string="Telefono", required=True)
    email = fields.Char(string="Email", required=True)
    interesado = fields.Boolean(string="Interesado")
