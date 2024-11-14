import React, { useRef } from 'react';

function AddPost({ onAddPost }) {

    const titleRef = useRef('');
    const contentRef = useRef('');

    const handleClear = () => {
        titleRef.current.value = '';
        contentRef.current.value = '';
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        const title = titleRef.current.value;
        const content = contentRef.current.value;

        if (title.trim().length === 0 || content.trim().length === 0) {
            alert("Please fill in all fields");
        } else {
            onAddPost({
                title: title,
                content: content,
                "author": "Alice Johnson",
                "user_id": 1
            });
            handleClear();
        }
    };

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