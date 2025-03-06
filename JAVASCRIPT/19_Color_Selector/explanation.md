# Color Selector
### Explain in your own words why event.stopPropagation() is useful in this example.

Based on my own understanding, it is usually used in a foreach where there are a 
lot of buttons inside the container. Instead of using a basic eventListener click 
without an object, I think it's a very messy code. It is important because if you 
click a specific item, it will run the code inside the eventListener, and it will
 not perform again if there are more items. It's just like a break in a loop.