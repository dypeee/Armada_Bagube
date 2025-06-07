import React from 'react'


function SignUp() {
    
    const blue = {
        backgroundColor : '#2B78E4',
        borderRadius:'5px',
        color: 'white',
        padding: '0.5rem 1rem',
        border: 'none',
    }



    return (
        <div>
            <fieldset>
                <legend>Sign Up</legend>
                <form>
                    <input type="text" name='username' placeholder='Name' />
                    <input type="email" name='email' placeholder='Email' />
                    <input type="text" name='username' placeholder='Username' />
                    <input type="password" name='password' placeholder='Password' />
                    <input type="text" name='address' placeholder='Address' />
                    <input type="number" name='number' placeholder='Contact Number' />
                    <input type="submit" value='Sign Up' style={blue}/>
                </form>
            </fieldset>

        </div>
    )
}

export default SignUp