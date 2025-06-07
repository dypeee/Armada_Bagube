import React from 'react'
import image from '../assets/logo.png'

function Status() {
    return (
        <>
            <div className='classSection'>

                <img src={image} alt="" />
                <div className='contentContainer'>
                    <div className='userInformation'>
                        <h6>Monkey D. Luffy</h6>
                        <p>May 06, 2024 - 3:30pm</p>
                    </div>
                    <div className='contentName'>
                        Content Content Content Content Content Content Content Content Content Content Content Content
                    </div>
                </div>

            </div>
        </>
    )
}

export default Status