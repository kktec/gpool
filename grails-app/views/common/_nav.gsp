<div id= "main_nav" class="nav">
    <ul>
        <li>
            <ul>
              <sec:ifLoggedIn>
                  <li id="greeting">Welcome, <sec:username/></li>
                  <li>
                    <g:if test="${title != 'Home'}">
                        <g:link uri="/pool/home" class="home">Home</g:link>
                    </g:if>
                  </li>
                  <li>
                    <g:if test="${title != 'Profile'}">
                        <g:link uri="/user/profile">Your Profile</g:link>
                    </g:if>
                  </li>
                  <sec:ifAllGranted roles="ROLE_POOL">
                      <li>
                        <g:if test="${title != 'Scheduling'}">
                            <g:link uri="/scheduling">Scheduling</g:link>
                        </g:if>
                      </li>
                  </sec:ifAllGranted>
                  <sec:ifAllGranted roles="ROLE_ADMIN">
                      <li>
                        <g:if test="${title != 'Admin'}">
                            <g:link uri="/admin">Admin</g:link>
                        </g:if>
                      </li>
                  </sec:ifAllGranted>
                  <li><g:link uri="/signOut">Sign Out</g:link></li>
              </sec:ifLoggedIn>
              <sec:ifNotLoggedIn>
                  <li>
                    <g:if test="${title != 'Welcome'}">
                        <g:link uri="/" class="home">Home</g:link>
                    </g:if>
                  </li>
              </sec:ifNotLoggedIn>
            </ul>
         </li>
    </ul>
</div>
