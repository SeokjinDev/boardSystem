import React from "react";
import styled from "styled-components"
import CommentListItem from "./comment-list-item";

const Wrapper = styled.div `
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    :hover {
        background: lightgrey;
    }
`;

function CommentList(props) {
    const { comments } = props;
    return (
        <Wrapper>
            {comments.map((comment, index) => {
                return <CommentListItem key={comment.id} comment={comment} />
            })}
        </Wrapper>
    )
}

export default CommentList;