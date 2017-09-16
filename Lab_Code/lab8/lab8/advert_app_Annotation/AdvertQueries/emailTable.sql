CREATE TABLE `emailtable` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `emailId` varchar(225) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_email_user` FOREIGN KEY (`id`) REFERENCES `usertable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


<c:choose>
                                <c:when test="${currentPage eq i}">
                                    <td>${i}</td>
                                    <c:forEach begin="1" end="${noOfPages}" var="i">
                                        <td><a href="addBook.htm?page=${i}">${i}</a></td>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                <td><a href="addBook.htm?page=${i}">${i}</a></td>
                                       
                                </c:otherwise>
                                </c:choose>