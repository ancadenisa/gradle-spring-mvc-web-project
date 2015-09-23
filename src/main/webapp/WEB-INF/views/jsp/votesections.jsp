</br></br></br>
<div class="container">
	<div class="row">
		<c:forEach var="voteSection" items='${voteSectionList}'>
			<div class="col-md-4">
				<h2>${voteSection.id}</h2>
				<p>Adresa:</p>
				<p>
					${voteSection.city}
					${voteSection.street}
					${voteSection.number}
				</p>
			</div>
		</c:forEach>
	</div>
</div>
