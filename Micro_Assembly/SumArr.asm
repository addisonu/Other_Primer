TITLE SumArr						   (SumArr.asm)
; Creation Date : 04/20/15 
; Revisions : 1
; Date : 04/21/15
; Program Description : 
	;(1) Summing array elements in a range. Create a procedure that returns the sum of all array elements falling within the range j...k (inclusive).
	;(2) Write a test program that calls the procedure twice, passing a pointer to a signed double word array, the size of the array, and the values of j and k. return the sum in the EAX register and preserve all other register values between calls to the procedure.    

INCLUDE Irvine32.inc
  
    .data
    arr1 SDWORD 1,2,3,4,5
    arr2 SDWORD 34,12,65,43,76
    j SDWORD ?
    k SDWORD ?
    sum SDWORD ?

    .code
main PROC
; First call to SumArr
	mov j,2
	mov k,4
	mov ecx,LENGTHOF arr1
	mov edi,OFFSET arr1
	call SumArr
	call WriteInt
	call Crlf
	
; Second call to SumArr
	mov j,13
	mov k,71
	mov ecx,LENGTHOF arr2
	mov edi,OFFSET arr2
	call SumArr
	call WriteInt
	call Crlf
exit
main ENDP

SumArr PROC
	mov sum,0
	L1:
	mov eax, [edi]
	.IF (eax >= j) && (eax <= k)
		add sum,eax
	.ENDIF
	add edi,TYPE sum
	loop L1
	mov eax,sum
	ret
SumArr ENDP

END main
