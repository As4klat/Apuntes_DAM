   M S B A M L   `   `   `  ����  Actividad21-20    *Actividad21_2.Componentes.PanelHabilidades   5      R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      .��5      ]� -   5          ]�Name$  panelHabilidades��5      ��.  $��Stretch=�6@   .+�5	   
   �� -   5         ��Name$ Cabecera��5	       �� Orientation$ Vertical=�6'   $	��Top=�6�   $��0,0,0,10q�6�   $
��Auto��6�   ��6>   �� *ActualWidth+ �� ElementName$ PanelCambiante�� �� Mode$ OneWay=�.+�5
      �� -   5        $ CabeceraTitulo��5
      $ Vertical=�61   $��Stretch=�6�   $��Stretch=�6�   $��0,0,0,1q�6�   $��55��6�   ��6H   �� *ActualWidth+$ PanelCambiante��$ OneWay=���5      �� 5       �� EndPoint$	 1,1&�6*    �� 
StartPoint$ 0.5,0&�69   .��5      �  � Color$ 	#FFC54444��6'   � 5      $ 	#FF790C0C��6'    � Offset$ 1Q�69   5      .+�5      �� -   5        	 ��Name$	 borderCabecera��5      $��2,2,2,2q�62   $��2,2,2,2q�6L   
���   �$��Stretch=�6q   $��52��6�   ._�5      �� -   5        $ PanelTitulo��5   !   $ 
Horizontal=�66   $��0,0,0,0q�6O   $��LeftToRight=�6`   $��Stretch=�6|   .+�5      �� -   5        
 ��Name$
 tituloCabecera��5       $��Titulo��68   $��Center=�6I   $
��Left=�6d   $
��Left=�6�   
�������$��Segoe UI)�6�   $��18(�6�   $��20,0,0,0q�6�   $
��Bold"�6�   $��Center=�6�   $	��250��6   J� Effect 5      3  -System.Windows.Media.Effects.DropShadowEffect  5   "   -   5        TituloShadowEffect��   ShadowDepth$ 3Q�5   5      	Direction$	 330Q�5   5      Color$ Black��5   5      Opacity$	 0.8Q�5   5      
BlurRadius$ 1Q�5   5   5      �� 5      -   5        $
 PuntosEnRama��5       $!��Puntos gastados en la rama:��66   $��Stretch=�6\   $��Segoe UI)�6�   
�������$��18(�6�   $
��Bold"�6�   $��Center=�6�   $��Right=�6�    5        5   "   -	   5        PuntosEnRamaShadowEffect��$ 3Q�5    5   $	 330Q�5!   5   $ Black��5"   5   $	 0.8Q�5#   5   $ 1Q�5$   5   5&      5'      5(      5)      �� 5*      -
   5        $ CabeceraCategorias��5*      $ 
Horizontal=�65   $��60��6N   $��Stretch=�6Z   ��5+      �� 5,       �� Color$ 	#FF5685B5��6&    �� Opacity$ 1Q�68   .+�5.      �� -   5        $
 CabezeraHabilidad1��5.      $��Attaque
Rapido��64   $��Stretch=�6Q   $��Stretch=�6o   $��24,0,0,0q�6�   ���	#FFFCFCFC$
��Bold"�6�   $��Center=�6�   $��Center=�6�   $��90��6  $
��Auto=�6   5/        50      -   5        "CabezeraHabilidad1ShadowEffect��$ 3Q�51   -   $	 330Q�52   -   $ Black��53   -   $	 0.8Q�54   -   $ 1Q�55   -   57      �� 58      -   5        $
 CabezeraHabilidad2��58      $��Ataque
Fuerte��64   $��Stretch=�6P   $��Stretch=�6n   $��24,0,0,0q�6�   $��90��6�   ���	#FFFCFCFC$
��Bold"�6�   $��Center=�6�   $��Center=�6�   $
��Auto=�6   59        5:      -   5        "CabezeraHabilidad2ShadowEffect��$ 3Q�5;   -   $	 330Q�5<   -   $ Black��5=   -   $	 0.8Q�5>   -   $ 1Q�5?   -   5A      �� 5B      -   5        $
 CabezeraHabilidad3��5B      $��Defensa��64   $��Stretch=�6F   $��Stretch=�6d   $��24,0,0,0q�6�   $��90��6�   ���	#FFFCFCFC$
��Bold"�6�   $��Center=�6�   $��Center=�6�   $
��Auto=�6   5C        5D      -   5        "CabezeraHabilidad3ShadowEffect��$ 3Q�5E   -   $	 330Q�5F   -   $ Black��5G   -   $	 0.8Q�5H   -   $ 1Q�5I   -   5K      �� 5L      -   5        $
 CabezeraHabilidad4��5L      $��Tirador��64   $��Stretch=�6F   $��Stretch=�6d   $��24,0,0,0q�6�   $��90��6�   ���	#FFFCFCFC$
��Bold"�6�   $��Center=�6�   $��Center=�6�   $
��Auto=�6   5M        5N      -   5        "CabezeraHabilidad4ShadowEffect��$ 3Q�5O   -   $	 330Q�5P   -   $ Black��5Q   -   $	 0.8Q�5R   -   $ 1Q�5S   -   5U      �� 5V      -   5        $
 CabezeraHabilidad5��5V      $��Tirador��64   $��90��6F   ���	#FFFCFCFC$
��Bold"�6h   $��Center=�6z   $��Center=�6�   $��24,0,0,0q�6�   $��Stretch=�6�   $��Stretch=�6�   $
��Auto=�6   5W        5X      -   5        #CabezeraHabilidad4ShadowEffect1��$ 3Q�5Y   -   $	 330Q�5Z   -   $ Black��5[   -   $	 0.8Q�5\   -   $ 1Q�5]   -   5_      5`      5a      �� 5b   
   -   5        $ GrupoHabilidadesT1��5b      $ 
Horizontal=�61   $	��Top=�6J   $��0,0,0,2q�6_   ���	#FF773F076p   �� 5c   
   -   5        $ GrupoHabilidadesT2��5c      $ 
Horizontal=�61   $	��Top=�6J   $��0,0,0,2q�6_   ���	#FF773F076p   �� 5d   
   -   5        $ GrupoHabilidadesT3��5d      $ 
Horizontal=�61   $	��Top=�6J   $��0,0,0,2q�6_   ���	#FF773F076p   �� 5e   
   -   5        $ GrupoHabilidadesT4��5e      $ 
Horizontal=�61   $	��Top=�6J   $��0,0,0,2q�6_   ���	#FF773F076p   5f      5g      