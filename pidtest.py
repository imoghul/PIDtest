import time
class pidtest:

        P=0;
        I=0;
        D=0;
        lasterror = 0
        lastintegral=0
        dt = .01
        def __init__(self, P,I,D):
            self.P = P
            self.I=I
            self.D=D    


        def reset(self):
                self.lasterror=0
                self.lastintegral=0

        def pidcontroller(self, current, desired):
                error = desired-current
                integral = self.lastintegral + (error*self.dt)
                derivative = (error-self.lasterror)/self.dt

                output = self.P*error + self.I*integral + self.D*derivative
                self.lasterror = error
                self.lastintegral = integral
                time.sleep(self.dt)
                return output
