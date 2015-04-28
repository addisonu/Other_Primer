TITLE CalcGrade								      (CalcGrade.asm)
; Creation Date : 04/17/15
; Revisions : 1
; Date : 04/17/15
; Program Description :
	; Create a procedure named CalcGrade that receives an integer value between 0 and 100, and returns  single capital letter in the AL register. Preserve all other values between calls to the procedure. The letter returned by the procedure should be according to the following:
	; Score 90 to 100 Grade A
	; Score 80 to 89 Grade B
	; Score 70 to 79 Grade C
	; Score 60 to 69 Grade D
	; Score 0 to 59 Grade F
	; Write test program that generates 10 random integers between 50 and 100 inclusive. Each time an integer is generated, pass is to the CalcGrade procedure.

INCLUDE Irvine32.inc
    
	.data
	grade BYTE ?,0
	grA BYTE "A",0
	grB BYTE "B",0
	grC BYTE "C",0
	grD BYTE "D",0
	grF BYTE "F",0
	out_of_range BYTE "The integer is not <= 100 and >= 0",0
	
	.code
main PROC
	call Randomize
	mov ecx,10
L1: 
	mov eax,51
	call RandomRange
	add eax,50
	call GradeCalc
	mov edx,0
	mov grade,al
	mov edx, OFFSET grade
	call WriteString
	call Crlf
	loop L1
    exit
main ENDP

GradeCalc PROC
	.IF (eax <= 100 && eax >= 0)
		.IF (eax <= 100) && (eax > 89)
			mov al,grA
		.ELSEIF (eax < 90) && (eax > 79)
			mov al,grB
		.ELSEIF (eax < 80) && (eax > 69)
			mov al,grC
		.ELSEIF (eax < 70) && (eax > 59)
			mov al,grD
		.ELSE
			mov al,grF
		.ENDIF

	.ELSE
		mov edx,OFFSET out_of_range
		call WriteString
		call Crlf
		ret
	.ENDIF

	ret

GradeCalc ENDP
END main
