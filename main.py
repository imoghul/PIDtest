import pygame 
import time
from pidtest import pidtest
PID = pidtest(.1,3,.00001)#pidtest(.7,.1,0.001)#pidtest(1.5,.5,.001)#pidtest(.1,3,.00001)
# Initializing Pygame 
pygame.init() 
running = True
    # Initializing surface 
x = 0
y = 0
    
    # Initialing Color
while(running):
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        # Drawing Rectangle 
    PID.reset()


    color = (0,255,0) 
    desiredx = int(input("X: "))#pygame.mouse.get_pos()[0]#50;
    desiredy = int(input("Y: "))#pygame.mouse.get_pos()[1]
    print(pygame.mouse.get_pos()[0],pygame.mouse.get_pos()[1])
    while(abs(x-desiredx)>.1):
        surface = pygame.display.set_mode((800,600))
        surface.fill((0,0,0))
        x+= PID.pidcontroller(x,desiredx)
        pygame.draw.rect(surface, color, pygame.Rect(x, y, 60, 60)) 
        pygame.display.flip()
    PID.reset()
    while(abs(y-desiredy)>.1):
        surface = pygame.display.set_mode((800,600))
        surface.fill((0,0,0))
        y+= PID.pidcontroller(y,desiredy)
        pygame.draw.rect(surface, color, pygame.Rect(x, y, 60, 60)) 

        pygame.display.flip()
    time.sleep(1)
    
    
pygame.quit()