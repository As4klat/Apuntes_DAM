# -*- coding: utf-8 -*-
# from odoo import http


# class Construcion(http.Controller):
#     @http.route('/construcion/construcion/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/construcion/construcion/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('construcion.listing', {
#             'root': '/construcion/construcion',
#             'objects': http.request.env['construcion.construcion'].search([]),
#         })

#     @http.route('/construcion/construcion/objects/<model("construcion.construcion"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('construcion.object', {
#             'object': obj
#         })
