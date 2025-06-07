import React from 'react'

function SignIn() {
    const green = {
        backgroundColor : '#085736',
        borderRadius:'5px',
        color: 'white',
        padding: '0.5rem 1rem',
        border: 'none',
    }

    return (
        <div>
            <fieldset>
                <legend><h3>Sign In</h3></legend>
                <form>
                    <input type="text" name='username' placeholder='Username' />
                    <input type="password" name='password' placeholder='Password' />
                    <input type="submit" value='Log In' style={green}/>
                </form>
            </fieldset>

        </div>
    )
}

export default SignIn