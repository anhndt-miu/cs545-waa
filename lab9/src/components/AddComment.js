import React, { useRef } from 'react';

function AddComment({ onAddComment }) {
    const handleClear = () => {
        commentRef.current.value = '';
    };

    const commentRef = useRef('');
    const handleSubmit = (event) => {
        event.preventDefault();
        const comment = commentRef.current.value;
        if (comment.trim().length === 0) {
            alert("Please fill in all fields");
        } else {
            onAddComment({ name: comment });
            handleClear();
        }
    };

    return (
        <div className="add-comment" >
            <h1>Add comment</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    ref={commentRef}
                    value={commentRef.name}
                    placeholder="Enter comment"
                    className="text-input"
                />
                <div className="button-group">
                    <button type="submit" className="add-button" >Add Comment</button>
                    <button type="button" onClick={handleClear} className="clear-button" >Clear</button>
                </div>
            </form>
        </div>
    );
}

export default AddComment;