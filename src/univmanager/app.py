import turtle

# create a turtle object
t = turtle.Turtle()

# set turtle properties
t.pensize(5)
t.speed(2)

# draw the snake body
t.penup()
t.goto(0, 0)
t.pendown()
t.circle(50, 180)
t.circle(80, 180)

# draw the snake head
t.penup()
t.goto(80, 0)
t.pendown()
t.circle(30)

# draw the snake eye
t.penup()
t.goto(95, 20)
t.pendown()
t.dot(10)

# draw the apple
t.penup()
t.goto(-120, 0)
t.pendown()
t.fillcolor('red')
t.begin_fill()
t.circle(30)
t.end_fill()

# draw the apple stem
t.penup()
t.goto(-120, 30)
t.pendown()
t.pensize(3)
t.right(45)
t.forward(20)
t.left(45)
t.forward(20)

# move turtle to the snake's mouth
t.penup()
t.goto(50, -10)

# draw the bite mark
t.pendown()
t.pensize(10)
t.right(60)
t.forward(20)
t.left(120)
t.forward(20)

# hide the turtle
t.hideturtle()

# keep the turtle window open
turtle.done()
