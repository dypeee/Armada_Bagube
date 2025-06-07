import React from 'react'
import Status from './Status'
import './css/Post.css'


function Post() {
	return (
		<div className='postComponent'>
			<div>
				<h6>Hey! Nakama what's on your mind?</h6>
				<textarea name="" placeholder='Text Here...'></textarea>
			</div>
			<Status />
			<Status />
			<Status />
		</div>
	)
}

export default Post