import './App.css'

function App() {

    // const currentTime = new Date().getHours();
    const currentTime = Math.floor(Math.random() * 24);
    let greeting;

    if (currentTime >= 5 && currentTime <= 11) {
        greeting = <h1>"Good Morning"</h1>;
    } else if (currentTime >= 12 && currentTime <= 17) {
        greeting =  <h1>"Good Afternoon"</h1>;
    } else {
        greeting = <h1>"Good Evening"</h1>;
    }

    return (
        <>
            <div>
                {greeting}
            </div>
        </>
    )
}

export default App
