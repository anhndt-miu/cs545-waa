import React from "react";


export default function PostItem({ post }) {
    return (
        <div className="grid-item" >
            <p>{post?.id??''}</p>
            <h2>{post?.title??''}</h2>
            <p>{post?.author??''}</p>
        </div>
    );
}