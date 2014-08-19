<div id= "main_nav" class="nav">
    <ul>
        <li>
            <ul>
              <sec:ifLoggedIn>
                  <li><g:link uri="/pool/home" class="home">Home</g:link></li>
                  <li><g:link uri="/user/profile">Your Profile</g:link></li>
                  <li><g:link uri="/signOut">Sign Out</g:link></li>
              </sec:ifLoggedIn>
              <sec:ifNotLoggedIn>
                  <li><g:link uri="/" class="home">Home</g:link></li>
              </sec:ifNotLoggedIn>
            </ul>
         </li>
    </ul>
</div>
