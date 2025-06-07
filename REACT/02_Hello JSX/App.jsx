import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
    const [count, setCount] = useState(0)

        const greetings =  'Hello, JSX!';
        const name =  'React Developer';
        const year =  2025;
    return (
        <>
            <div>
                <h1>{greetings}, Welcome to the {name} Journey in {year}</h1>
            </div>
        </>
    )
}

export default App
