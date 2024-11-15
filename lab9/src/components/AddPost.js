import React, { useRef } from 'react';
import ApiService from '../services/ApiServices';
import { useNavigate } from 'react-router-dom';

function AddPost( ) {
    const navigate = useNavigate();
    const titleRef = useRef('');
    const contentRef = useRef('');

    const handleClear = () => {
        titleRef.current.value = '';
        contentRef.current.value = '';
    };

    const handleSubmit = async (event) => {
        try {
            event.preventDefault();
            const title = titleRef.current.value;
        const content = contentRef.current.value;

        if (title.trim().length === 0 || content.trim().length === 0) {
            alert("Please fill in all fields");
        } else {
             await ApiService.addPost({
                title: title,
                content: content,
                "author": "Alice Johnson",
                "user_id": 1
            });

            handleClear();
            navigate('/');
        }
       
        } catch (error) {
            alert("Something went wrong while add post");
        }
    }

    return (
        <div className="add-post-card" >
            <h1>Add Post</h1>
            <form onSubmit={handleSubmit}>
            <input
                    type="text"
                    ref={titleRef}
                    placeholder="Enter title"
                    className="text-input"
                />
                <input
                    type="text"
                    ref={contentRef}
                    placeholder="Enter content"
                    className="text-input"
                />
                <div className="button-group">
                    <button type="submit" className="add-button" >Add Post</button>
                    <button type="button" onClick={handleClear} className="clear-button" >Clear</button>
                </div>
            </form>

        </div>
    );
}

export default AddPost;