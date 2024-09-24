import matplotlib.pyplot as plt
import numpy as np

# Función para construir el tapete de Sierpinski
def sierpinski_carpet(n):
    if n == 0:
        return np.ones((3, 3), dtype=int)
    else:
        # Recursión
        smaller_carpet = sierpinski_carpet(n - 1)
        carpet = np.tile(smaller_carpet, (3, 3))
        carpet[len(smaller_carpet):2*len(smaller_carpet), len(smaller_carpet):2*len(smaller_carpet)] = 0
        return carpet

# Profundidad de la recursión
n = 4  # Puedes cambiar este valor para obtener diferentes niveles de detalle

# Genera el tapete
carpet = sierpinski_carpet(n)

# Muestra el tapete
plt.imshow(carpet, cmap="binary")
plt.axis('off')
plt.show()
