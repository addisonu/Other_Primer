TITLE SwapEle   (SwapEle.asm)
; Creation Date : 05/03/15
; Revisions : 4
; Date : 05/21/15
; Program Description :
    ; Create an array of randomly ordered integers. Using the Swap procedure from Sec 8.4.6 as a tool, write a loop that exchanges each consecutive pair of integers in an array.

INCLUDE Irvine32.inc

Swap PROTO, ptrArray:PTR DWORD, szArray:DWORD

    .data
    array DWORD 1,2,3,4,5,6,7,8
    .code

    main PROC
            pushad
            mov esi,OFFSET array
            mov ecx, LENGTHOF array
            mov ebx,TYPE array
            call DumpMem
            INVOKE Swap, ADDR Array, LENGTHOF array/2
            call DumpMem
            call Crlf
            popad
            exit
            main ENDP

    Swap PROC USES eax esi edi ecx, ptrArray:PTR DWORD, szArray:DWORD
            mov esi,ptrArray
            mov edi,ptrArray
            add edi,SIZEOF DWORD
            mov ecx,szArray
    L1:
            mov eax,[esi]
            xchg eax,[edi]
            mov [esi],eax
            add esi,SIZEOF DWORD
            add esi,SIZEOF DWORD
            add edi,SIZEOF DWORD
            add edi,SIZEOF DWORD
            loop L1
            ret

    Swap ENDP
    END main
